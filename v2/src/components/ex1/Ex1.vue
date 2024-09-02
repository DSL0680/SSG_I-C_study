<template>
    <div>

        <h1>Ex1</h1>

        <h2 v-text="str"></h2>

        <h2>{{ str }}</h2>

        <h2 v-html="str"></h2>

        <hr/>

        <template v-if="str">
            AAAA
        </template>
        <template v-else="str">
            BBBB
        </template>

    </div>
</template>

<script setup>

let str = null

</script>

<style lang="scss" scoped>

</style>