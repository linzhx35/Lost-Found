<template>
    <div class="login-container">
      <div class="login-background"></div>
      <div class="login-form">
        <h2>Welcome to Lost And Found System</h2>
        <form @submit.prevent="login">
          <input type="text" v-model="username" placeholder="Please enter the username">
          <input type="password" v-model="password" placeholder="Please enter the password">
          <select v-model="role">
            <option disabled value="">Please choose your role</option>
            <option>Admin</option>
            <option>User</option>
          </select>
          <button type="submit">Login</button>
        </form>
        <p>Don't have an account ? <a @click="goToSignUp">Join</a></p>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  import { mapActions } from 'vuex';
  import { useRouter } from 'vue-router';

  export default {
    data() {
      return {
        username: '',
        password: '',
        role: ''
      };
    },
    methods: {
      ...mapActions(['login']),
      async login() {
        try {
          const response = await axios.post('/api/user/login', {
            username: this.username,
            password: this.password
          });
          this.login(response.data);
          this.$router.push({ name: 'HomePage' });
        } catch (error) {
          console.error('Login failed', error);
        }
      },
      goToSignUp() {
        this.$router.push({ name: 'SignUp' });
      }
    }
  };
  </script>
  
  <style scoped>
  .login-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    position: relative;
  }
  
  .login-background {
    position: absolute;
    width: 100%;
    height: 100%;
    background: url('@/assets/background.jpg') no-repeat center center;
    background-size: cover;
    z-index: -1;
  }
  
  .login-form {
    background: white;
    padding: 1rem 3rem;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    text-align: center;
    width: 600px; 
    font-size: 1.2rem; 
  }
  
  .login-form h2 {
    margin-bottom: 1.5rem;
    font-size: 2rem; 
  }
  
  .login-form input, .login-form select {
    display: block;
    width: 100%;
    padding: 0.5rem;
    margin-bottom: 1.2rem;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 1.2rem;
  }
  
  .login-form button {
    background-color: #ffc107;
    border: none;
    padding: 1rem 1.5rem;
    border-radius: 4px;
    font-size: 1.2rem;
    cursor: pointer;
    color: white;
  }
  
  .login-form p {
    margin-top: 1rem;
  }
  
  .login-form a {
    color: #007bff;
    text-decoration: none;
  }
  </style>
  