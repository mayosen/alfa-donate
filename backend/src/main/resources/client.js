let userToken = "09c41e6d-3c35-492f-8f85-8d009d27ee61"
let donateSource = new EventSource(`http://localhost:8080/donate/${userToken}`)
let fundSource = new EventSource(`http://localhost:8080/fund/${userToken}`)

let donateQueue = []
let fundQueue = []

donateSource.addEventListener('donate', event => {
    let donate = JSON.parse(event.data)
    console.log(`${donate.nickname} задонатил ${donate.amount} рублей и сказал '${donate.message}'`)
    donateQueue.push(donate)
});

fundSource.addEventListener('fundUpdate', event => {
    let fund = JSON.parse(event.data)
    console.log(`собрано ${fund.collected} из '${fund.aim}'`)
    fundQueue.push(fund)
});

function showDonate() {
    let donate = donateQueue.pop()
    if (donate === undefined) {
        return;
    }
    console.log(`показ доната`)
}

function updateFund() {
    let fund = fundQueue.pop()
    if (fund === undefined) {
        return;
    }
    console.log(`обновление сбора`)
}

let donateTimer = setInterval(showDonate, 1000)
let fundTimer = setInterval(updateFund, 1000)
