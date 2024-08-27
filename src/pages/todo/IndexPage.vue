<template>
    <div class="container my-5">

        <h2 class="text-center mb-4">Todo Sub Index Page</h2>

        <div class="d-flex justify-content-center mb-4">

            <span>
                <RouterLink to="/todo/add" class="btn btn-primary">Add New Todo</RouterLink>
            </span>

        </div>

        <RouterView></RouterView>

    </div>
</template>

<script setup>
import { RouterView, RouterLink } from 'vue-router';
</script>

<style lang="scss" scoped></style>
