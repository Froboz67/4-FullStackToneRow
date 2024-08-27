<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <button v-on:click="handleClick">Create Random Tone Row</button>
  </div>
</template>

<script>
export default {
  methods: {
    handleClick() {
      this.$store.dispatch("resetState");
      this.$router.push({ name: "randomToneRow" });
    },
  },
};
</script>
