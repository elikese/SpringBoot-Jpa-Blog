let index = {
    init: function () {
        document.querySelector("#btn-save").addEventListener('click',() =>{
            this.save();
        })
    },

    save: function () {
        alert('user의 save 호출');
    }
}

index.init();