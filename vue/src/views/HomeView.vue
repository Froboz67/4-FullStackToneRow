<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <button v-on:click="$router.push({name: 'randomToneRow'})">Create Random Tone Row</button>
  </div>
</template>

<script>
export default {
};
</script>
