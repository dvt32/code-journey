// https://leetcode.com/problems/categorize-box-according-to-criteria/

function categorizeBox(length: number, width: number, height: number, mass: number): string {
    const volume: number = length * width * height;
    const isBulky: boolean =
        (length >= 10000 || width >= 10000 || height >= 10000 || mass >= 10000) ||
        (volume >= 1_000_000_000);
    const isHeavy: boolean = (mass >= 100);
    
    if (isBulky && isHeavy) return "Both";
    if (isBulky && !isHeavy) return "Bulky";
    if (!isBulky && isHeavy) return "Heavy";

    return "Neither";
};
