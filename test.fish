#!/usr/local/bin/fish

set file ./src/main/kotlin/me/sargunvohra/lib/pokekotlin/api/IPokeApi.kt

set paths (cat $file | grep -o '\".*\"' | cut -d '"' -f 2)
set funcs (cat $file | grep -o 'fun get.*List' | cut -d ' ' -f 2 | cut -d '(' -f 1)

for i in (seq (count $funcs))
	echo "	@Test"
	echo "	fun $funcs[$i]() {"
	echo "		test(-1, \"$paths[$i]-1/\", \"\") {"
	echo "			PokeApi.$funcs[$i]()"
	echo "		}"
	echo "	}"
	echo
end