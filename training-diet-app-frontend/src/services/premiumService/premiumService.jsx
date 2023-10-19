async function getPremiumUserIndicators() {
    return await fetch("http://localhost:9800/premium-user/indicators")

}

export default getPremiumUserIndicators