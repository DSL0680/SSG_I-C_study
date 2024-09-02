<script setup>
import { postOne } from "../../apis/todoAPI.js";
import { onMounted, ref } from "vue";
import { useRouter } from "vue-router";
import useMember2 from "../../stores/useMember2.js";

const router = useRouter();

const todo = ref({
    title: '',
    writer: '',
    dueDate: ''
});

const { computedMid } = useMember2()

const handleClick = async () => {
    console.log(todo.value);
    const res = await postOne(todo.value);

    alert(`Todo ${res.mno} has been added successfully!`);

    router.replace("/todo/list")
};

onMounted(() => {

    todo.value.writer = computedMid.value

})
</script>

<template>
    <div class="container mt-5">
        <h1 class="mb-4 text-center">Add New Todo</h1>

        <div class="mb-3">
            <label for="title" class="form-label">Title</label>
            <input type="text" id="title" v-model="todo.title" class="form-control" placeholder="Enter title">
        </div>

        <div class="mb-3">
            <label for="writer" class="form-label">Writer</label>
            <input type="text" id="writer" v-model="computedMid" class="form-control"  readonly>
        </div>

        <div class="mb-3">
            <label for="dueDate" class="form-label">Due Date</label>
            <input type="date" id="dueDate" v-model="todo.dueDate" class="form-control">
        </div>

        <div class="text-center">
            <button @click="handleClick" class="btn btn-primary">Add Todo</button>
        </div>
    </div>
</template>

<style scoped></style>