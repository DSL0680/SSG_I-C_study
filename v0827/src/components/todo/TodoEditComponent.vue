<template>
    <div class="container my-5">
        <!-- 에러 메시지 -->
        <div v-if="error != null" class="alert alert-danger">
            ERROR: {{ error }}
        </div>

        <!-- TODO 항목 편집 폼 -->
        <div v-if="error === null">
            <div class="mb-3">
                <label for="mno" class="form-label">MNO</label>
                <input type="text" id="mno" v-model="todo.mno" class="form-control" readonly>
            </div>

            <div class="mb-3">
                <label for="title" class="form-label">Title</label>
                <input type="text" id="title" v-model="todo.title" class="form-control">
            </div>

            <div class="mb-3">
                <label for="writer" class="form-label">Writer</label>
                <input type="text" id="writer" v-model="todo.writer" class="form-control" readonly>
            </div>

            <div class="mb-3">
                <label for="dueDate" class="form-label">Due Date</label>
                <input type="date" id="dueDate" v-model="todo.dueDate" class="form-control">
            </div>

            <div v-if="isAuthor">
                <button @click="handleClickModify" :disabled="!isAuthor" class="btn btn-primary">
                    MODIFY
                </button>
                <button @click="handleClickDelete" :disabled="!isAuthor" class="btn btn-danger">
                    DELETE
                </button>
            </div>

        </div>
    </div>
</template>

<script setup>
import { useRoute, useRouter } from 'vue-router';
import { deleteOne, getOne, putOne } from '../../apis/TodoAPI';
import { onMounted, ref, computed } from 'vue';
import useMember2 from '../../stores/useMember2';

const { computedMid } = useMember2()

const route = useRoute()
const router = useRouter()

const mno = route.params.mno

const todo = ref({
    mno: 0,
    title: '',
    writer: '',
    dueDate: ''
})

const isAuthor = computed(() => {
    return computedMid.value === todo.value.writer;
});

const handleClickDelete = () => {
    if (isAuthor.value) {
        deleteOne(mno).then(() => {
            router.replace("/todo/list");
        });
    } else {
        alert("You are not authorized to delete this todo.");
    }
};

const handleClickModify = () => {
    if (isAuthor.value) {
        putOne(todo.value).then(result => {
            router.replace(`/todo/read/${mno}`);
        });
    } else {
        alert("You are not authorized to modify this todo.");
    }
};

const error = ref(null)

onMounted(() => {
    getOne(mno).then(data => todo.value = data).catch((err) => {
        error.value = err.response?.data?.message || 'An error occurred'
    })
})
</script>

<style lang="scss" scoped></style>
