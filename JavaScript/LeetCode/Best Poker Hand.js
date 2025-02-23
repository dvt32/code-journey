// https://leetcode.com/problems/best-poker-hand/

/**
 * @param {number[]} ranks
 * @param {character[]} suits
 * @return {string}
 */
var bestHand = function(ranks, suits) {
    let uniqueSuits = new Set(suits);
    
    if (uniqueSuits.size == 1) {
        return "Flush";
    }

    let rankCounts = new Map();
    let foundTwo = false;

    for (let rank of ranks) { 
        rankCounts.set(rank, (rankCounts.get(rank) || 0) + 1) 
    }
    for (let rankCount of rankCounts.values()) {
        if (rankCount >= 3) {
            return "Three of a Kind";
        } else if (rankCount == 2) {
            foundTwo = true;
        }
    }
    
    if (foundTwo) {
        return "Pair";
    }

    return "High Card";
};
