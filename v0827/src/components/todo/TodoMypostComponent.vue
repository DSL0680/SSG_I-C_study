<template>
    <div class="container mt-4">
        <h1 class="mb-4">Todo MyPosts Component</h1>

        <div v-if="myPosts.length === 0">
            <p class="text-center">작성한 내역이 없습니다.</p>
        </div>
        <div v-else>
            <ul class="list-group">
                <li v-for="post in myPosts" :key="post.mno" class="list-group-item d-flex justify-content-between align-items-center">
                    <RouterLink :to="`/todo/read/${post.mno}`" class="text-decoration-none">{{ post.title }}</RouterLink>
                    <span class="badge bg-secondary">{{ post.dueDate }}</span>
                </li>
            </ul>
        </div>
    </div>
</template>

<script setup>
import { getList } from '../../apis/TodoAPI';
import useMember2 from '../../stores/useMember2';
import { computed, onMounted, ref } from 'vue';

const posts = ref([]);

const { computedMid } = useMember2();

const myPosts = computed(() => {
    return posts.value.filter(post => post.writer === computedMid.value);
});

onMounted(async () => {
    try {
        const res = await getList();
        posts.value = res.content;
    } catch (error) {
        console.error('Error fetching posts:', error);
    }
});
</script>

<style lang="scss" scoped></style>
