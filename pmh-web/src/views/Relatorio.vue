<template>
  <transition mode="out-in">
    <section class="card">
      <h2>Relatório</h2>
      <form>
        <div class="filtro">
          <input
            name="cliente"
            id="cliente"
            class="busca"
            type="text"
            placeholder="Buscar por Nome do Cliente..."
          />
          <input
            name="tecnico"
            id="tecnico"
            class="busca"
            type="text"
            placeholder="Buscar por Nome do Técnico..."
          />
          <input
            name="tipo"
            id="tipo"
            class="busca"
            type="text"
            placeholder="Buscar por Tipo de Atendimento..."
          />
        </div>
        <input
          class="btn"
          type="button"
          value="Gerar Relatório"
          @click.prevent="submit"
        />
      </form>
    </section>
  </transition>
</template>

<script>
export default {
  name: "Relatorio",
  components: {},
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
    document.title = "Relatório";
  },
};
</script>

<style scoped>
.card {
  margin: 20px;
}
h2 {
  padding: 10px 0;
  text-align: center;
}

form {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 0 10px;
}

.filtro {
  display: flex;
}

.busca {
  width: 100%;
  padding: 20px;
  border: none;
  margin: 20px;
}

.busca:focus,
.busca:hover {
  transform: scale(1.1);
}
.btn {
  max-width: 200px;
}
</style>
