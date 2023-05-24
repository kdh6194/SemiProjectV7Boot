const writebtn = document.querySelector("#writebtn");
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