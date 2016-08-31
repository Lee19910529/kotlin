/*
 * Copyright 2010-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.ir2cfg.builders

import org.jetbrains.kotlin.ir.IrElement
import org.jetbrains.kotlin.ir2cfg.graph.ControlFlowGraph

interface ControlFlowGraphBuilder {
    // Add element to the builder pointer
    fun add(element: IrElement)

    // Move builder pointer to element without changing graph
    fun move(to: IrElement)

    // Connect builder pointer with the given element and move pointer to this element
    fun jump(to: IrElement)

    // Connect from with to and move pointer to the destination
    fun jump(to: IrElement, from: IrElement)

    // Build CFG from builder
    fun build(): ControlFlowGraph
}