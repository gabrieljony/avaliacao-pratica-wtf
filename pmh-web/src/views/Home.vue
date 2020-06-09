<template>
  <section class="cards-container">
    <transition mode="out-in">
      <div class="cards">
        <div class="card">
          <router-link :to="{ name: 'registrar' }">
            <p class="title">Registrar Atendimento</p>
          </router-link>
        </div>
        <div class="card">
          <router-link :to="{ name: 'relatorio' }">
            <p class="title">Relatório</p>
          </router-link>
        </div>
        <div class="card">
          <router-link :to="{ name: 'tipo-cadastro' }">
            <p class="title">Tipo de Atendimento</p>
          </router-link>
        </div>
        <div class="card">
          <router-link :to="{ name: 'usuario-cadastro' }">
            <p class="title">Cadastrar Técnico</p>
          </router-link>
        </div>
      </div>
    </transition>
  </section>
</template>

<script>
export default {
  name: "Home",
  components: {},
  created() {
    document.title = "Sistema de Atendimento";
  },
};
</script>

<style scoped>
.cards-container {
  max-width: 1000px;
  margin: 0 auto;
}

.cards {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-gap: 30px;
  margin: 30px;
}

@media screen and (max-width: 500px) {
  .cards {
    grid-template-columns: repeat(2, 1fr);
    grid-gap: 10px;
    margin: 10px;
  }
}

.card {
  box-shadow: 0 4px 8px rgba(30, 60, 90, 0.1);
  padding: 10px;
  background: #fff;
  border-radius: 4px;
  transition: all 0.2s;
}

.card:hover {
  box-shadow: 0 6px 12px rgba(30, 60, 90, 0.2);
  transform: scale(1.1);
  position: relative;
  z-index: 1;
}

.title {
  display: flex;
  justify-content: center;
  margin: 10px 0;
  color: #e80;
  font-weight: bold;
}
</style>
