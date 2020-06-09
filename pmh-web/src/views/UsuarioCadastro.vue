<template>
  <transition mode="out-in">
    <section class="card">
      <h2>Cadastro de Usuário - Técnico</h2>
      <form>
        <label for="nome">Nome do Técnico</label>
        <input id="nome" name="nome" type="text" />
        <label for="cpf">CPF</label>
        <input id="cpf" name="cpf" type="text" />
        <label for="email">E-mail</label>
        <input id="email" name="email" type="email" />
        <label for="type">Tipo de Usuário</label>
        <input id="type" name="type" type="text" />
        <input
          class="btn"
          type="button"
          value="Cadastrar"
          @click.prevent="submit"
        />
      </form>
    </section>
  </transition>
</template>

<script>
export default {
  name: "UsuarioCadastro",
  data() {
    return {};
  },
  methods: {
    submit() {
      this.erros = [];
      this.$router.push({ name: "home" });
    },
  },
  created() {
    document.title = "Usuário :: Cadastro";
  },
};
</script>

<style scoped>
.card {
  max-width: 500px;
  margin: 20px auto;
}
h2 {
  padding: 10px 0;
  text-align: center;
}
</style>
