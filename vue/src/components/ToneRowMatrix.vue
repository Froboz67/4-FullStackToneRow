<template>
  <div>
    <div class="header-container">
      <h1>Tone Row Matrix</h1>
      <h1>Tone Row by Pitch Class</h1>
    </div>
    <div class="tone-grid d-flex flex-nowrap">
      <div
        class="grid-item"
        v-for="pitch in pitchClassArray"
        v-bind:key="pitch"
        @mouseover="onNoteMouseOver(pitch)"
      >
        {{ pitch.note }}
      </div>
    </div>
  </div>
</template>

<script>
export default {
  computed: {
    pitchClassArray() {
      return this.$store.state.pitchClassArray;
    },
  },
  methods: {
    onNoteMouseOver(pitch) {
      this.$store.dispatch("playSound", pitch);
    },
  },
};
</script>

<style scoped>
.header-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 10px;
  margin-bottom: 20px;
}
.tone-grid {
  overflow-x: auto; /* Allows horizontal scrolling if the viewport is too small */
  display: flex;
  gap: 10px;
  justify-content: center;
}

.grid-item {
  white-space: nowrap; /* Prevents the text from breaking */
  font-size: 1rem; /*Default size*/
  display: flex;
  align-items: center;
  justify-content: center;
  width: 50px; /* Adjust width as needed */
  height: 50px; /* Adjust height as needed */
  background-color: #f0f0f0; /* Background color */
  border: 1px solid #ddd; /* Border around items */
  border-radius: 4px; /* Rounded corners (optional) */
  transition: background-color 0.3s; /* Transition for hover effect */
}
.grid-item:hover {
  background-color: #b0e57c; /* Background color on hover */
}

@media (max-width: 576px) {
  .grid-item {
    font-size: 0.8rem;
  }
}
</style>