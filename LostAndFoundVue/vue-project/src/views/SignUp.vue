<template>
    <div class="signup-container">
      <div class="signup-background"></div>
      <div class="signup-form">
        <h2>Create Your Account</h2>
        <form @submit.prevent="signUp">
          <input type="text" v-model="username" placeholder="Please enter your username">
          <input type="email" v-model="email" placeholder="Please enter your email">
          <input type="password" v-model="password" placeholder="Please enter your password">
          <input type="password" v-model="confirmPassword" placeholder="Please confirm your password">
          <button type="submit">Sign Up</button>
        </form>
        <p v-if="error">{{ error }}</p>
        <p>Already have an account? <a href="/login">Log In</a></p>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  import { useRouter } from 'vue-router';

  export default {
    data() {
      return {
        username: '',
        email: '',
        password: '',
        confirmPassword: '',
        error: ''
      };
    },
    methods: {
      async signUp() {
        if (this.password !== this.confirmPassword) {
          this.error = 'Passwords do not match';
          return;
        }
        try {
          await axios.post('/api/user/register', {
            username: this.username,
            password: this.password,
            email: this.email,
            role: 'User'
          });
          this.$router.push({ name: 'Login' });
        } catch (error) {
          if (error.response && error.response.status === 400) {
            this.error = error.response.data.message;
          } else {
            this.error = 'Sign up failed. Please try again later.';
          }
        }
      },
      goToLogin() {
        this.$router.push({ name: 'Login' });
      }
    }
  };
  </script>
  
  <style scoped>
  .signup-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    position: relative;
  }
  
  .signup-background {
    position: absolute;
    width: 100%;
    height: 100%;
    background: url('@/assets/background.jpg') no-repeat center center;
    background-size: cover;
    z-index: -1;
  }
  
  .signup-form {
    background: white;
    padding: 1rem 3rem;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    text-align: center;
    width: 600px; 
    font-size: 1.2rem; 
  }
  
  .signup-form h2 {
    margin-bottom: 1.5rem;
    font-size: 2rem; 
  }
  
  .signup-form input, .signup-form select {
    display: block;
    width: 100%;
    padding: 0.5rem;
    margin-bottom: 1.2rem;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 1.2rem;
  }
  
  .signup-form button {
    background-color: #ffc107;
    border: none;
    padding: 1rem 1.5rem;
    border-radius: 4px;
    font-size: 1.2rem;
    cursor: pointer;
    color: white;
  }
  
  .signup-form p {
    margin-top: 1rem;
  }
  
  .signup-form a {
    color: #007bff;
    text-decoration: none;
  }
  </style>
  