<template>
    <div>
        <h1>{{ props.title }}</h1>
        <slot></slot>
    </div>
</template>

<script setup>
const props = defineProps(['title'])

</script>

<style scoped>
div {
    border: 1px solid black;
    width: 50vw;
    min-height: 10vh;
    margin: 0.2em;
    padding: 0.3em;    
}
</style>