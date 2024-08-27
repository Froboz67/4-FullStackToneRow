<template>
  <div>
    <div class="header-container">
      <h1>Random Tone Row</h1>
      <button v-on:click="createRandomToneRow">Build Random ToneRow</button>
    </div>
    <div class="tone-grid d-flex flex-nowrap">
      <div class="grid-item" v-for="tone in toneRowArray" v-bind:key="tone">
        {{ tone }}
      </div>
    </div>
    <div class="header-container">
      <h1>Tone Row by Pitch Class</h1>
      <div class="button-group d-flex flex-nowrap">
        <button v-on:click="createPitchClassSharp">
          View Pitch Class in Sharps
        </button>
        <button v-on:click="createPitchClassFlat">
          View Pitch Class in Flats
        </button>
      </div>
    </div>
    <div v-if="isPitchClassVisible" class="tone-grid d-flex flex-nowrap">
      <div
        class="grid-item"
        v-for="pitch in pitchClassArray"
        v-bind:key="pitch"
        @mouseover="onNoteMouseOver(pitch)"
      >
        {{ pitch.note }}
      </div>
    </div>
    <div class="header-container">
      <h1>Tone Row Matrix</h1>
      <button v-on:click="$router.push({ name: 'toneRowMatrix' })">
        View Tone Row Matrix
      </button>
    </div>
    <p v-if="outOfOrderMessage" class="error-message">
      {{ outOfOrderMessage }}
    </p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      outOfOrder: 0,
      outOfOrderMessage: "",
    };
  },
  methods: {
    createRandomToneRow() {
      this.resetState();
      let toneRowSet = new Set();
      while (toneRowSet.size < 12) {
        toneRowSet.add(Math.floor(Math.random() * 12));
        this.$store.dispatch("updateToneRowArray", Array.from(toneRowSet));
      }
      console.log(this.toneRowArray);
      this.outOfOrder = 1;
    },
    createPitchClassSharp() {
      if (this.outOfOrder === 0) {
        this.outOfOrderMessage = "Please build a random tone row first";
      }

      const SharpTones = Object.freeze({
        0: { note: "C", frequency: 261.63 },
        1: { note: "C#", frequency: 277.18 },
        2: { note: "D", frequency: 293.66 },
        3: { note: "D#", frequency: 311.13 },
        4: { note: "E", frequency: 329.63 },
        5: { note: "F", frequency: 349.23 },
        6: { note: "F#", frequency: 369.99 },
        7: { note: "G", frequency: 392.0 },
        8: { note: "G#", frequency: 415.3 },
        9: { note: "A", frequency: 440.0 },
        10: { note: "A#", frequency: 466.16 },
        11: { note: "B", frequency: 493.88 },
      });
      const pitchClassArray = this.toneRowArray.map((tone) => SharpTones[tone]);
      this.$store.dispatch("updatePitchClassArray", pitchClassArray);

      // console.log(this.pitchClassArray);
      console.log(this.$store.getters.getPitchClassArray);
    },
    createPitchClassFlat() {
      if (this.outOfOrder === 0) {
        this.outOfOrderMessage = "Please build a random tone row first";
      }

      const FlatTones = Object.freeze({
        0: { note: "C", frequency: 261.63 },
        1: { note: "Db", frequency: 277.18 },
        2: { note: "D", frequency: 293.66 },
        3: { note: "Eb", frequency: 311.13 },
        4: { note: "E", frequency: 329.63 },
        5: { note: "F", frequency: 349.23 },
        6: { note: "Gb", frequency: 369.99 },
        7: { note: "G", frequency: 392.0 },
        8: { note: "Ab", frequency: 415.3 },
        9: { note: "A", frequency: 440.0 },
        10: { note: "Bb", frequency: 466.16 },
        11: { note: "B", frequency: 493.88 },
      });
      const pitchClassArray = this.toneRowArray.map((tone) => FlatTones[tone]);
      this.$store.dispatch("updatePitchClassArray", pitchClassArray);

      console.log(this.pitchClassArray);
    },
    resetState() {
      this.outOfOrder = 0;
      this.outOfOrderMessage = "";
      this.$store.dispatch("resetState");
      // this.pitchClassArray = [];
      // this.toneRowArray = [];
    },
    onNoteMouseOver(pitch) {
      this.$store.dispatch("playSound", pitch);
    },
  },
  computed: {
    toneRowArray() {
      return this.$store.getters.getToneRowArray;
    },
    pitchClassArray() {
      return this.$store.getters.getPitchClassArray;
    },
    isPitchClassVisible() {
      return this.$store.getters.getIsPitchClassVisible;
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
  gap: 10px; /* Space between grid items */
  justify-content: center; /* Center items horizontally */
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
.button-group {
  overflow-x: auto;
  white-space: nowrap;
  display: flex;
  flex-direction: row;
  gap: 10px;
}

.error-message {
  font-weight: bold;
  font-size: 28px;
  color: red;
  margin-top: 20px;
}
@media (max-width: 576px) {
  .grid-item {
    font-size: 0.8rem;
  }
}
</style>