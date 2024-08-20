<template>
    <div>
        <h1>Count Buttons</h1>
        <div>
            <button @click="() => emits('changeCount',1)">+</button>
            <button @click="() => emits('changeCount',-1)">-</button>
        </div>
    </div>
</template>

<script setup>
const emits = defineEmits(['changeCount'])
</script>

<style lang="scss" scoped>

</style>