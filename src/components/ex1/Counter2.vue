<template>
    <div>
        <div>
            <h1>COUNT2 {{ count.num }}</h1>
            <h1>COUNT2 {{ count.nums }}</h1>
        </div>
        <div>
            <button @click="plus">PLUS</button>
            <button @click="minus">MINUS</button>
        </div>
    </div>
</template>

<script setup>
import { reactive } from 'vue';

const count = reactive( { num:10, nums:[] } )

const plus = () => {
    count.num += 1
    count.nums.push('A')
}

const minus = () => {
    count.num -= 1
    count.nums.push('B')
    
}

</script>

<style lang="scss" scoped>

</style>