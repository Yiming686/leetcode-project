package Lai.Interview;

public class Top_50_Git_Commits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/*

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

  # get_rate_limit
  get_all_commits
  # get_filtered_commits
}

main


*/