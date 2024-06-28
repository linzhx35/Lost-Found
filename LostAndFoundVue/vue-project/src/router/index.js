import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../views/HomePage.vue';
import Login from '../views/Login.vue';
import SignUp from '../views/SignUp.vue';
import LostItems from '../views/LostItems.vue';
import Feedback from '../views/Feedback.vue';

const routes = [
  {  path: '/', name: 'HomePage', component: HomePage },
  {  path: '/login', name: 'Login', component: Login },
  {  path: '/signup', name: 'SignUp', component: SignUp },
  {  path: '/lostitems', name: 'LostItems', component: LostItems },
  {  path: '/Feedback', name: 'Feedback', component: Feedback }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;
