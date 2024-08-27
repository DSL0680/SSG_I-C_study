<template>
    <div>
        <div>
            <h1>Todo MyPosts Component</h1>
        </div>

        <div v-if="myPosts.length === 0">
            <p>작성한 내역이 없습니다.</p>
        </div>
        <div v-else>
            <ul>
                <li v-for="post in myPosts" :key="post.mno">
                    <RouterLink :to="`/todo/read/${post.mno}`">{{ post.title }}</RouterLink>
                    <span>
                        {{ post.dueDate }}
                    </span>
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

        posts.value = res.content

    } catch (error) {
        console.error('Error fetching posts:', error);
    }

});
</script>

<style lang="scss" scoped></style>