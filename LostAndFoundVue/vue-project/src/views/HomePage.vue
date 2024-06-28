<template>
  <div class="flex-col page">
    <div class="flex-row items-center header">
      <img
        class="image"
        src="@/assets/logo.png"
      />
      <div class="flex-row group_2">
        <span class="font">Home</span>
        <span class="font ml-47">Lost</span>
        <span class="font ml-47">Found</span>
        <span class="font ml-47">Feedback</span>
      </div>
      <div class="flex-row group">
        <template v-if="isAuthenticated">
          <div class="user-menu" @mouseover="showDropdown = true" @mouseleave="showDropdown = false">
            <span>{{ user.username }}</span>
            <div v-if="showDropdown" class="dropdown-menu">
              <div>My Lost Items</div>
              <div>My Found Items</div>
              <div>Contacts</div>
              <div>Profile</div>
              <div @click="logout">Logout</div>
            </div>
          </div>
        </template>
        <template v-else>
          <div class="flex-col justify-start items-center button" @click="goToLogin">
            <span class="font_2">Log in</span>
          </div>
          <div class="flex-col justify-start items-center button ml-51" @click="goToSignUp">
            <span class="font_2">Sign up</span>
          </div>
        </template>
      </div>
    </div>
    <div class="flex-col flex-1 group_3">
      <div class="flex-row">
        <div class="flex-row justify-between group_4 equal-division-item">
          <span class="self-center font_3 text">Newly Lost</span>
          <span class="self-start font_4 text_2">See more</span>
        </div>
        <div class="ml-72 flex-row justify-between group_4 equal-division-item">
          <span class="self-center font_3 text">Newly Lost</span>
          <span class="self-start font_4 text_2">See more</span>
        </div>
      </div>
      <div class="flex-row justify-between group_5 view">
        <div class="flex-row">
          <div class="flex-col">
            <div class="flex-col items-start">
              <img
                class="image_2"
                src="@/assets/lost1.png"
              />
              <span class="font_5 mt-19">Title</span>
            </div>
            <div class="flex-col items-start mt-35">
              <span class="font_6">Description</span>
              <span class="font_6 text_3">Date: 2024-6-15</span>
            </div>
          </div>
          <div class="flex-col ml-91">
            <div class="flex-col items-start">
              <img
                class="image_2"
                src="@/assets/lost2.png"
              />
              <span class="font_5 mt-19">Title</span>
            </div>
            <div class="flex-col items-start mt-35">
              <span class="font_6">Description</span>
              <span class="font_6 text_4">Date: 2024-6-15</span>
            </div>
          </div>
        </div>
        <div class="flex-row group_6">
          <div class="flex-col">
            <div class="flex-col items-start">
              <img
                class="image_2"
                src="@/assets/found1.png"
              />
              <span class="font_5 mt-19">Title</span>
            </div>
            <div class="flex-col items-start mt-35">
              <span class="font_6">Description</span>
              <span class="font_6 text_5">Date: 2024-6-15</span>
            </div>
          </div>
          <div class="flex-col ml-91">
            <div class="flex-col items-start">
              <img
                class="image_2"
                src="@/assets/found2.png"
              />
              <span class="font_5 mt-19">Title</span>
            </div>
            <div class="flex-col items-start mt-35">
              <span class="font_6">Description</span>
              <span class="font_6 text_6">Date: 2024-6-15</span>
            </div>
          </div>
        </div>
      </div>
      <div class="flex-row justify-between group_5 view_2">
        <div class="flex-row">
          <div class="flex-col">
            <div class="flex-col items-start">
              <img
                class="image_2"
                src="@/assets/lost1.png"
              />
              <span class="font_5 mt-19">Title</span>
            </div>
            <div class="flex-col items-start mt-35">
              <span class="font_6">Description</span>
              <span class="font_6 text_3">Date: 2024-6-15</span>
            </div>
          </div>
          <div class="flex-col ml-91">
            <div class="flex-col items-start">
              <img
                class="image_2"
                src="@/assets/lost1.png"
              />
              <span class="font_5 mt-19">Title</span>
            </div>
            <div class="flex-col items-start mt-35">
              <span class="font_6">Description</span>
              <span class="font_6 text_4">Date: 2024-6-15</span>
            </div>
          </div>
        </div>
        <div class="flex-row group_6">
          <div class="flex-col">
            <div class="flex-col items-start">
              <img
                class="image_2"
                src="@/assets/lost1.png"
              />
              <span class="font_5 mt-19">Title</span>
            </div>
            <div class="flex-col items-start mt-35">
              <span class="font_6">Description</span>
              <span class="font_6 text_5">Date: 2024-6-15</span>
            </div>
          </div>
          <div class="flex-col ml-91">
            <div class="flex-col items-start">
              <img
                class="image_2"
                src="@/assets/lost1.png"
              />
              <span class="font_5 mt-19">Title</span>
            </div>
            <div class="flex-col items-start mt-35">
              <span class="font_6">Description</span>
              <span class="font_6 text_6">Date: 2024-6-15</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { reactive, computed } from 'vue';
import { useRouter } from 'vue-router';
import { useStore } from 'vuex';

const props = defineProps({});
const data = reactive({
  showDropdown: false,
});
const router = useRouter();
const store = useStore();

const user = computed(() => store.getters.user);
const isAuthenticated = computed(() => store.getters.isAuthenticated);

function goToLogin() {
  router.push({ name: 'Login' });
}
function goToSignUp() {
  router.push({ name: 'SignUp' });
}
function logout() {
  store.dispatch('logout');
}

</script>

<style scoped>
@import '../assets/homepage.css';
@import '../assets/main.css';

.user-menu {
  position: relative;
}
.dropdown-menu {
  position: absolute;
  top: 100%;
  left: 0;
  background: white;
  border: 1px solid #ccc;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  z-index: 1000;
  width: 150px;
}
.dropdown-menu div {
  padding: 10px;
  cursor: pointer;
}
.dropdown-menu div:hover {
  background: #f5f5f5;
}
</style>
