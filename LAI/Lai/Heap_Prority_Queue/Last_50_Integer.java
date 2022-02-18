package Lai.Heap_Prority_Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import Company.Walmart.Find_Least_Floors;

public class Last_50_Integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6, 16,  4, 19, 26, 30, 22, 10, 29, 20,  8, 27, 14, 17, 12};
		Arrays.sort(arr);
		System.out.println(""+Arrays.toString(arr));
		System.out.println(""+findLast(arr, 5));
	}

	private static List<Integer> findLast(int[] arr, int k) {
		// TODO Auto-generated method stub
		List<Integer> result = new ArrayList<Integer>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
		for(int i = 0; i < arr.length; i++) {
			int val = arr[i];
			if(minHeap.size() < k) {
				minHeap.offer(val);
			}else if(minHeap.peek() < val) {
				minHeap.poll();
				minHeap.offer(val);
			}
		}
		while(!minHeap.isEmpty()) {
			result.add(minHeap.poll());
		}
		return result;
	}

}

/*
 * 
 #!/bin/bash
set -euo pipefail
set -o posix
IFS=$'\n\t'

# TODO - allow command line options for count and GH repo

function get_all_commits {

  local all_sha=$(curl 'https://api.github.com/repos/stedolan/jq/commits?per_page=50' \
  | jq '.[] | {author: .commit.author.name, name: .commit.committer.name, sha: .sha}')

  if [ -z "$all_sha" ]; then
    >&2 echo "No sha found"
    exit 1
  fi

  echo "$all_sha"
}

function get_filtered_commits {

  local unique_sha=$(curl 'https://api.github.com/repos/stedolan/jq/commits?per_page=50' \
  | jq '.[] | select(.commit.author.name == .commit.committer.name) | .sha')

  if [ -z "$unique_sha" ]; then
    >&2 echo "No unique sha found"
    exit 1
  fi

  echo "$unique_sha"
}

function get_rate_limit {

  local rate_limit=$(curl 'https://api.github.com/rate_limit')
  # TODO enable error check if rate check fails, exit
  echo "$rate_limit"
}

function main {

  get_rate_limit
  get_all_commits
  get_filtered_commits
}

main

 */ 
