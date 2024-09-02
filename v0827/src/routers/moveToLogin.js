import useMember2 from "../stores/useMember2";


// moveToLogin 함수 정의
export const moveToLogin = (to, from, next) => {
    const { userId } = useMember2(); // 스토어에서 member 가져오기

    const checkLogin = () => {
        return userId.mid ? true : false;
    };

    console.log('move to todo add page: ' + checkLogin());

    if (checkLogin()) {
        next();
    } else {
        next('/login');
    }
};