package com.sbk.leetcode.binarytree.tasks;

import com.google.common.collect.Lists;
import com.sbk.leetcode.binarytree.TreeUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Lists.newArrayList;
import static com.sbk.leetcode.binarytree.TreeUtil.toTreeNode;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class BottomUpTraversalTest {

    BottomUpTraversal but = new BottomUpTraversal();

    @Test
    public void levelOrderBottom() throws Exception {
        List<Integer> es1 = newArrayList(15, 7);
        List<Integer> es2 = newArrayList(9, 20);
        List<Integer> es3 = newArrayList(3);
        List<List<Integer>> ex = newArrayList(es1, es2, es3);
        assertThat(but.levelOrderBottom(toTreeNode(new Integer[]{3,9,20,null,null,15,7})),
                equalTo(ex));

    }

}