<template>
  <transition mode="out-in">
    <section class="atendimento">
      <h2>Registrar Atendimento</h2>
      <form class="registrar">
        <label for="datetime">Data da Execução</label>
        <input id="datetime" name="datetime" type="text" />
        <label for="type">Tipo de Atendimento</label>
        <input id="type" name="type" type="text" />
        <label for="nome">Nome do Cliente</label>
        <input id="nome" name="nome" type="text" />
        <label for="description">Observações</label>
        <textarea id="description" name="description"></textarea>
        <input
          class="btn"
          type="button"
          value="Registrar"
          @click.prevent="submit"
        />
      </form>
    </section>
  </transition>
</template>

<script>
export default {
  name: "Registrar",
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
    document.title = "Registrar Atendimento";
  },
};
</script>

<style scoped>
.atendimento {
  max-width: 500px;
  margin: 20px auto;
}
h2 {
  padding: 10px 0;
  text-align: center;
}
</style>
