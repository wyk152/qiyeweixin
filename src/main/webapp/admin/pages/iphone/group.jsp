<%@ page language="java" contentType="text/html; charset=UTF-8"%>
 <script type="text/x-template" id="item-template">
  <li>
    <div
      :class="{bold: isFolder}"
      @click="toggle"
      @dblclick="changeType">
      <span v-if="isFolder">[{{open ? '-' : '+'}}]</span>
      {{model.name}}
    </div>
    <ul v-show="open" v-if="isFolder">
      <item
        class="item"
        v-for="model in model.children"
        :model="model">
      </item>
      <li class="add" @click="addChild">+</li>
    </ul>
  </li>
</script>


<!-- the demo root element -->
<ul id="demo">
  <item
    class="item"
    :model="treeData">
  </item>
</ul>