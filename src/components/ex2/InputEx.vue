<template>
    <div>
        <h1>INPUT EX</h1>
        <div>
            <input type="text" v-model="input.v1">
        </div>
        <div>
            <input type="text" v-model="input.v2">
        </div>
        <div>
            {{ input.v1 }}
            {{ input.v2 }}
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';


const input = ref( {v1: 'AAA', v2: 'BBB'} )

</script>

<style lang="scss" scoped>

</style>