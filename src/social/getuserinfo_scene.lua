cc.exports.userinfoscene = {}


local umShare = require "umSocialForLua"

local function getCallback(platform, stCode, data)
    local result = "";
     if (stCode == 200) {
         result = "获取成功";
        print("#### 获取成功");
    } else if (stCode == 0) {
        print("#### 获取出错");
    } else if (stCode == -1) {
        print("#### 取消获取");
    }
    for k,v in pairs(data) do
        print("#### data  "..k.." -> "..v..".");
    end
    -- body
end


local function back(sender)
    -- body
    cc.Director:getInstance():popScene()
end

local function qq(sender)
    umShare.qq_getInfo("getCallback")
end

local function sina(sender)
    umShare.sina_getInfo("getCallback")
end

local function wx(sender)
    umShare.wx_getInfo("getCallback")
end


function userinfoscene.create()
	local scene = cc.Scene:create()
    local size = cc.Director:getInstance():getWinSize()
	local  item1 = cc.MenuItemFont:create("qq"):setPosition(cc.p(size.width/2,size.height/2+100))
    item1:registerScriptTapHandler(qq)
    local  item2 = cc.MenuItemFont:create("新浪"):setPosition(cc.p(size.width/2,size.height/2))
    item2:registerScriptTapHandler(sina)
    local  item3 = cc.MenuItemFont:create("微信"):setPosition(cc.p(size.width/2,size.height/2-100))
    item3:registerScriptTapHandler(wx)
    local  item4 = cc.MenuItemFont:create("返回"):setPosition(cc.p(cc.Director:getInstance():getWinSize().width-100,100))
	item4:registerScriptTapHandler(back)
    local  menu = cc.Menu:create()
	menu:addChild(item1)
    menu:addChild(item2)
    menu:addChild(item3)
    menu:addChild(item4)
    menu:setPosition(cc.p(0,0))
    scene:addChild(cc.Layer:create():addChild(menu))
	return scene
end


return cc.exports.userinfoscene
