<template>
  <div>
    <div class="header-container">
      <h1>Tone Row Matrix</h1>
      <h1>Tone Row by Pitch Class</h1>
      <button v-on:click="$router.push({ name: 'randomToneRow' })">
        Back to Tone Row
      </button>
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
    <button v-on:click="buildToneRowMatrix">Build Tone Row</button>
  </div>
</template>

<script>
export default {
  computed: {
    pitchClassArray() {
      console.log(this.$store.state.pitchClassArray);
      return this.$store.state.pitchClassArray;
    },
  },
  methods: {
    onNoteMouseOver(pitch) {
      this.$store.dispatch("playSound", pitch);
    },
    backToRandomToneRow() {
      this.$state.isPitchClassVisible = false;
      this.$router.push({ name: "randomToneRow" });
    },
    buildToneRowMatrix() {
      let matrix = [];
      matrix = this.$store.state.pitchClassArray;
      console.log("this is the matrix: ", matrix);
      let outputString = "";
      for (let [index, pitch] of matrix.entries()) {
        outputString += `${index}: | ${pitch.pitchValue} | ${pitch.baseZero} | ${pitch.note} | ${pitch.frequency} `;
      }
      console.log("This is the complete toneRow object: ", outputString);
      // let primeRows = [];
      // primeRows.push({
      //   pitchValue: // matrix index where the baseZero is 2
      //   baseZero: // matrix index where the baseZero is 2
      //   note: // matrix index where the baseZero is 2
      //   frequency: // matrix index where the baseZero is 2
      // })
    },
  },
};
</script>

<style scoped>
button {
  border-radius: 4px;
}
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
  margin-left: 2%;
  margin-right: 2%;
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