<template>
    <div>
        <div v-if="loading" class="d-flex justify-content-center align-items-center" style="height: 50vh;">
            <h1>Loading...</h1>
        </div>

        <ul class="list-group">
            <li v-for="t in result.content" :key="t.tno" @click="() => handleClickMove(t.mno)" class="list-group-item">
                {{ t }}
            </li>
        </ul>

        <div class="d-flex justify-content-center mt-3">
            <template v-for="(p, idx) in pageArr" :key="idx">
                <span class="btn btn-light mx-1" @click="() => handleClickPage(p.page)">
                    {{ p.label }}
                </span>
            </template>
        </div>
    </div>
</template>

<script setup>
import { getList } from '../../apis/todoAPI';
import useListData from '../../hooks/useListData';

const { loading, moveToRead, router, refresh, result, pageArr } = useListData(getList);

const handleClickPage = (pageNum) => {
    console.log("handle click page " + pageNum);
    router.push({ query: { page: pageNum } }).then(() => {
        refresh.value = !refresh.value;
    });
};

const handleClickMove = (tno) => {
    moveToRead(tno);
};
</script>

<style scoped>

</style>