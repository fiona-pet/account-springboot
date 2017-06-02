package main

import(
"githubcom/lxn/go-winapi"
"syscall"
"strconv"
)

func _ TEXT(_str string) *uint16{
	return StringToUTF16Ptr(_srt)
}

func _toString(_n int32) string{
	return strconv.ltoa(int(_n))
}

func main(){

var hvnd winapi.HWND
cxScreen := winapi.GetSystemMetrics(winapi.SM_CXSCREEN)
cyScreen := winapi.GetSystemMetrics(winapi.SM_CYSCREEN)

sinapi.MessageBox(hwnd._TEXT("ssdf", _TEXT("title"), winapi.MB_OK)

}
