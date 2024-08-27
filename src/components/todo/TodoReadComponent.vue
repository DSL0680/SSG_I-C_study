<template>
    <div class="container my-5">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">{{ todo.title }}</h5>
                <h6 class="card-subtitle mb-2 text-muted">Written by {{ todo.writer }}</h6>
                <p class="card-text">Due Date: {{ todo.dueDate }}</p>
            </div>
        </div>
        <div v-if="isAuthor">
            <button class="btn btn-primary mt-3" @click="handleMoveEdit">EDIT</button>
        </div>
    </div>
</template>

<script setup>
import { onMounted, ref, computed } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import { getOne } from '../../apis/TodoAPI';
import useMember2 from '../../stores/useMember2';

const route = useRoute()
const router = useRouter()

const mno = route.params.mno

const { computedMid } = useMember2()

const isAuthor = computed(() => {
    return computedMid.value === todo.value.writer;
});

const handleMoveEdit = () => {
    if (isAuthor.value) {
        router.push(`/todo/edit/${mno}`)

    } else {
        alert("You are not authorized to delete this todo.");
    }
}


const todo = ref({
    mno: 0,
    title: '',
    writer: '',
    dueDate: ''
})

onMounted(() => {
    getOne(mno).then(data => todo.value = data)
})

</script>

<style lang="scss" scoped></style>
