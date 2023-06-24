// https://leetcode.com/problems/return-length-of-arguments-passed

function argumentsLength(...args: any[]): number {
  return args.length;
};

/**
 * argumentsLength(1, 2, 3); // 3
 */
