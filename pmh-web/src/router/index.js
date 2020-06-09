import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home";
import Login from "../views/Login.vue";
import Registrar from "../views/Registrar.vue";
import TipoCadastro from "../views/TipoCadastro.vue";
import UsuarioCadastro from "../views/UsuarioCadastro.vue";
import Relatorio from "../views/Relatorio.vue";
import PaginaNaoEncontrada from "../views/PaginaNaoEncontrada.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "*",
    component: PaginaNaoEncontrada,
  },
  {
    path: "/",
    name: "login",
    component: Login,
  },
  {
    path: "/home",
    name: "home",
    component: Home,
  },
  {
    path: "/login",
    name: "login",
    component: Login,
  },
  {
    path: "/tipo-cadastro",
    name: "tipo-cadastro",
    component: TipoCadastro,
  },
  {
    path: "/usuario-cadastro",
    name: "usuario-cadastro",
    component: UsuarioCadastro,
  },
  {
    path: "/relatorio",
    name: "relatorio",
    component: Relatorio,
  },
  {
    path: "/registrar",
    name: "registrar",
    component: Registrar,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
  scrollBehavior() {
    return window.scrollTo({ top: 0, behavior: "smooth" });
  },
});

export default router;
