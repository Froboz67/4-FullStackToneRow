<template>
  <div>
    <div class="header-container">
      <h1>Random Tone Row</h1>
      <button v-on:click="createRandomToneRow">Build Random ToneRow</button>
    </div>
    <div class="tone-grid">
      <div class="grid-item" v-for="tone in toneRowArray" v-bind:key="tone">
        {{ tone }}
      </div>
    </div>
    <div class="header-container">
      <h1>Tone Row by Pitch Class</h1>
      <button v-on:click="createPitchClassSharp">
        View Pitch Class in Sharps
      </button>
      <button v-on:click="createPitchClassFlat">
        View Pitch Class in Flats
      </button>
    </div>
    <div class="tone-grid">
      <div
        class="grid-item"
        v-for="pitch in pitchClassArray"
        v-bind:key="pitch"
        @mouseover="playSound(pitch)"
      >
        {{ pitch.note }}
      </div>
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
      toneRowArray: [],
      pitchClassArray: [],
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
        this.toneRowArray = Array.from(toneRowSet);
      }
      console.log(this.toneRowArray);
      this.outOfOrder = 1;
    },
    createPitchClassSharp() {
      if (this.outOfOrder === 0) {
        this.outOfOrderMessage = "Please build a random tone row first";
      }

      this.pitchClassArray = [];
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

      for (let pitch of this.toneRowArray) {
        this.pitchClassArray.push(SharpTones[pitch]);
      }
      console.log(this.pitchClassArray);
    },
    createPitchClassFlat() {
      if (this.outOfOrder === 0) {
        this.outOfOrderMessage = "Please build a random tone row first";
      }

      this.pitchClassArray = [];
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
      for (let pitch of this.toneRowArray) {
        this.pitchClassArray.push(FlatTones[pitch]);
      }
      console.log(this.pitchClassArray);
    },
    resetState() {
      this.outOfOrder = 0;
      this.outOfOrderMessage = "";
      this.pitchClassArray = [];
      this.toneRowArray = [];
    },
    /**
     * Plays a sound based on the given pitch frequency during mouseover.
     *
     * @param {Object} pitch - An object containing information about the pitch to play.
     * @param {number} pitch.frequency - The frequency of the pitch to play.
     */
    playSound(pitch) {
      window.AudioContext = window.AudioContext || window.webkitAudioContext;
      const audioContext = new AudioContext();
      const oscillator = audioContext.createOscillator();
      const gainNode = audioContext.createGain();
      oscillator.connect(gainNode);
      gainNode.connect(audioContext.destination);
      oscillator.type = "sawtooth";
      oscillator.frequency.value = pitch.frequency;
      gainNode.gain.value = 0.5;
      oscillator.start();
      oscillator.stop(audioContext.currentTime + 1.5);
      console.log("playing " + pitch.note);
    },
  },
};
</script>

<style scoped>
.header-container {
  display: flex;
  align-items: center;
  gap: 10px;
  margin-bottom: 20px;
}
.tone-grid {
  display: flex;
  flex-wrap: wrap; /* Allows items to wrap to the next line if needed */
  gap: 10px; /* Space between grid items */
  justify-content: center; /* Center items horizontally */
}

.grid-item {
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

.error-message {
  color: red;
  margin-top: 20px;
}
</style>