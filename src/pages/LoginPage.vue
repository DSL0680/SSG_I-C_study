<template>
    <div class="container d-flex justify-content-center align-items-center vh-50">
        <div class="card p-4" style="width: 100%; max-width: 400px;">
            <h1 class="card-title text-center mb-4">Login Page</h1>
            <div class="mb-3">
                <label for="mid" class="form-label">User ID</label>
                <input type="text" id="mid" v-model="midInput" class="form-control" placeholder="Enter your User ID">
            </div>
            <button class="btn btn-primary w-100" @click="handleClick">Login</button>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import useMember2 from '../stores/useMember2';

const midInput = ref('')
const { signin } = useMember2()

const handleClick = () => {
    const mid = midInput.value
    signin(mid)
    
}
</script>

<style scoped></style>
