package com.topsail.skeleton;

import lombok.Data;

/**
 * @author Steven
 */
@Data
public class RestResult {
    private boolean success = true;
    private String message = "";
}
