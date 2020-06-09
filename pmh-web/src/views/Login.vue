<template>
  <section class="login">
    <h1>Login</h1>
    <form>
      <label for="email">Email</label>
      <input type="email" name="email" id="email" v-model="login.email" />
      <label for="senha">Senha</label>
      <input type="password" name="senha" id="senha" v-model="login.senha" />
      <button class="btn" @click.prevent="logar">Logar</button>
      <ErroNotificacao :erros="erros" />
    </form>
    <p class="esqueceu">
      <a href="/">Esqueceu a senha? Clique aqui.</a>
    </p>
  </section>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      login: {
        email: "",
        senha: "",
      },
      erros: [],
    };
  },
  methods: {
    logar() {
      this.erros = [];
      this.$router.push({ name: "home" });
    },
  },
  created() {
    document.title = "Login";
  },
};
</script>

<style scoped>
.login {
  max-width: 500px;
  margin: 0 auto;
  padding: 0 20px;
}

h1 {
  text-align: center;
  font-size: 2rem;
  margin-top: 40px;
  color: #87f;
}

form {
  display: grid;
}

.btn {
  width: 100%;
  max-width: 300px;
  margin-left: auto;
  margin-right: auto;
}

.esqueceu {
  text-align: center;
  margin: 20px auto 0 auto;
}

.esqueceu a:hover {
  color: #87f;
  text-decoration: underline;
}
</style>
