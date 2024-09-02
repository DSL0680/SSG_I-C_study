<template>
    <div>
        <div>
            <h1>COUNT {{ count.num }}</h1>
            <h1>COUNT {{ count.nums }}</h1>
        </div>
        <div>
            <button @click="plus">PLUS</button>
            <button @click="minus">MINUS</button>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';

const count = ref( { num:10, nums:[] } )

const plus = () => {
    count.value.num += 1
    count.value.nums.push('A')
}

const minus = () => {
    count.value.num -= 1
    count.value.nums.push('B')
    
}

</script>

<style lang="scss" scoped>

</style>