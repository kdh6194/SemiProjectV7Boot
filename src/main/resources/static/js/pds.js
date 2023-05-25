const writebtn = document.querySelector("#writebtn");
const newbtn = document.querySelector("#newbtn");
writebtn?.addEventListener('click', () => {
    const pfrm = document.forms.pfrm;
    if (pfrm.title.value === '') alert('제목을 작성하세요!');
    else if (pfrm.content.value === '') alert('본문을 작성하세요!');
    else {
        pfrm.method = 'post';
        pfrm.enctype = 'multipart/form-data';
        pfrm.submit();
    }
});
// 목록 보기
// 새글쓰기 버튼
newbtn?.addEventListener('click',()=>{
    location.href='/pds/write';
})