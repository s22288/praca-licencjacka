
 function  getUserData() {
    return  fetch("http://localhost:9800/normal-user/account-data")
}



async function updateUsersData(data) {
    return await fetch("http://localhost:9800/normal-user/update-data", {
        method: 'Post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }, body: JSON.stringify(data)
    }
    )
}


export { getUserData, updateUsersData }