import { moveToLogin } from "./moveToLogin";
import todoRouting from "./todo";
import { createRouter, createWebHistory } from "vue-router";

const MainPage = () => import("../pages/MainPage.vue")
const LoginPage = () => import("../pages/LoginPage.vue")
const NotFoundPage = () => import("../pages/NotFoundPage.vue");
const MypostsPage = () =>import("../pages/todo/MypostsPage.vue")


const routeConfig = createRouter({
    history: createWebHistory(),
    routes: [
        { path: "/", component: MainPage },
        { path: "/login", component: LoginPage },
        { path: '/:catchAll(.*)', component: NotFoundPage },
        { path: "/mypost", component: MypostsPage, beforeEnter: moveToLogin },
        todoRouting
    ]
})

export default routeConfig