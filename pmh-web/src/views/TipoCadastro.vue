<template>
  <transition mode="out-in">
    <section class="card">
      <h2>Tipo Atendimento - Cadastro</h2>
      <form>
        <label for="nome">Nome</label>
        <input id="nome" name="nome" type="text" />
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
  name: "TipoCadastro",
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
    document.title = "Tipo de Atendimento";
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
