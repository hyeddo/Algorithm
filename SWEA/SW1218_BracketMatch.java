package com.ssafy.algo.algo0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class SW1218_BracketMatch {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "182\r\n" + 
				"(({<(({{[[[[<<[[(<[[{([{{{[<[[[{<<(<[[{}[]{}{}[]]]><><>{})[]{}><>[]<>><>}][]]<>{}]>]()}()()(){}}}{}][])(){}<>()}]{}[]]>()[][][]){}]]{}[]<>><>{}[]{}<>>]]]][]{}{}[]()}}))>}<>{}()))[][]\r\n" + 
				"298\r\n" + 
				"{({{[({([{(<[([(([<({[{{[[({{[({([<{(<[[(<((<[{[<[([((<{{[([{<<[{(<({[<{}()>[]<>][]})>[])<>()[]}]>><>(){}()[]}]{}()<>[]<>)<>{}<>{}{}]}()}<>>)[]){}])]>[][]{}]()}][]()>[]))[]>)]][]>)[]{}}[]<><>>]()[])}{}){}]}}<><>){}][]{}{}]<>[]}(){}<>}][]})[]()><>]))])]>{}{}())}{}])<>}{})]{}{}}[])())<>{}[]<><>}[]{}\r\n" + 
				"230\r\n" + 
				"[({([<[<[<<(([{([<((({<{([{[<[<<<([<[<([[{([<[{({([<(<[[][]]<>{}<>[]>){}{}<>>]{}())})}[]]{}>[][][]]()[][]<><>()<>){}}]])[][][]>]>()](){}[])>>><><>{}]>]{}[]}<>][]())}[][]>}<>)()))>{}[]()])[][]}]<>()<>))>>()][]>][][]>]())}<><>{}<>)]\r\n" + 
				"226\r\n" + 
				"[[[{{[[<[([((([({{[{<<([[[([[{<[{{<{[<[([<<<((([{(<({<([(<><>){}])()[]>}<>())>){}}]))){}>()<><>>>[]]<>)]>]{}()}(){}>()<><>}}]()>}<>{}]])<>{}]()(){}][]()])[]{}(){}<>>[]>}{}{}](){}}})()])(){}<>))][])[]()<>]<><>>]()][]{}}}[]]]]()\r\n" + 
				"242\r\n" + 
				"((([<[{{<[<{<{({(({({({<{{{((([{[({[{<{{(([[{([{<<({<[]>}){}[]()()>>}[][]()][]<>){}<>}]]))}[]}()><>[]}(){}]()[][][]})]<>}{}<>](){}){}){})<><><>{}<>[]}}<>{}{}}{}[]>{}}(){}){}<>})}))[]})()}>[]{}{}()}>]>{}[][][][]}}][][][]{}<>>][])()[]))()()[]{}\r\n" + 
				"138\r\n" + 
				"{[<(({[{(({[(({{{]{<[([[({[[[[<>]]]{}]{}})]]()<>{}{}<>()<>)()<>{}[]<>]>{}})<>()<><><>}{}}}())){}]}))}()<>()[]{}]})<><><><>)>[][][]]}<>[]{}\r\n" + 
				"238\r\n" + 
				"{<[[({[([{{(({{((<({(<{{([<{<([((<<(<{[<<([{{[<[{<{{{[<[{<{[[]]}()[][]}()}]>]}{}{}}<>[]<>{}(){}}>}]{}{}><>[]]}[]{}()[]{}}]{}())()<><>()>>]()<>}>{}[])<>()>>()))()])>{}}>])}{}{}}>)()<>[]}){}>)<>)()}}())){}<>()}[][]}]){}<>[]<>]}[])]()]()>}<>\r\n" + 
				"272\r\n" + 
				"([{[<[[([([{[[([[({([(<[[[<{(({<([{([{<{[<<((({(<{<[({<{<<([[{<[[{{[<(([{}])<>)[]>]()<>}<>}[]]]{}()>}][]]{})<>{}[]>>}>{}<>}{})()]<>><>}[][]>)<>{}}[]<>))){}[]>>[]]}[]>}][])[]}]())>[]{}{}}[]{}))}>(){}[]{}]<>{}]]()>)<><><><>[]])}{})[]()]])]]}])<>][]{}<>)()]<><>()]>]<>}<>()])\r\n" + 
				"218\r\n" + 
				"[{({[<{[<{[[[<[{[[[[{([{[<[[<<[{{((<[([[<[(<[({}[]<>[]()[]()(){}){})<>()>[][]<>[])<><>[](){}[]{}<>]><>]])]>[]){}<>)[][]}}<><>()<>]<>><>{}>[]<>]{}]>]<>}]{}())[]}[]]<>]]]}]()>]<>(){}]()<>()]()}>{}<>]{}}>]()[]()[]})()}]()\r\n" + 
				"258\r\n" + 
				"({{[({<{<<{{([[<{({{{[[({[<(<{<<{<<{{{{([{[{<{{[<<[[[<[{<(<[({(<>)})]><>[])()>{}}[]]{}<>><>]]]<>>{}>]}{}[]}>}]<>[]}]){}<>{}}[]}}}{}<>>>}>[]><><>()<>[]}><>)><><><>]}){}]]<>[]<>}[]<>{}}}()<>)}<>{}[]>][]{}])<>[][]{}}()}>[]<>>}<><>>()}{}<><>[]()())<>]}{}{}[]}[])\r\n" + 
				"";
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < 10; tc++) {
			in.readLine();
			char[] brackets = in.readLine().toCharArray();

			Stack<Character> stack = new Stack<>();
			int result = match(brackets, stack);
			sb.append("#").append(tc+1).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static int match(char[] brackets, Stack<Character> stack) {
		int result = 1;
		for (int i = 0; i < brackets.length; i++) {
			if (brackets[i] == '(' || brackets[i] == '{' || brackets[i] == '[' || brackets[i] == '<') {
				stack.push(brackets[i]);
			} else if (stack.empty()) {
				result = 0;
				break;
			} else if ((brackets[i] == ')' && stack.peek() == '(') || (brackets[i] == '}' && stack.peek() == '{')
					|| (brackets[i] == ']' && stack.peek() == '[') || (brackets[i] == '>' && stack.peek() == '<')) {
				stack.pop();
			} else {
				result = 0;
				break;
			}
		}
		return result;
	}
}
