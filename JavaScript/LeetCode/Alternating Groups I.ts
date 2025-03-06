// https://leetcode.com/problems/alternating-groups-i/

function numberOfAlternatingGroups(colors: number[]): number {
    let altGroupCount: number = 0;
    const n: number = colors.length;

    if (colors[0] == colors[n-2] && colors[n-1] != colors[0]) {
        altGroupCount++;
    }
    if (colors[n-1] == colors[1] && colors[0] != colors[1]) {
        altGroupCount++;
    }
    for (let i = 1; i < n-1; ++i) {
        if (colors[i-1] == colors[i+1] && colors[i] != colors[i-1]) {
            altGroupCount++;
        }
    }

    return altGroupCount;
};
