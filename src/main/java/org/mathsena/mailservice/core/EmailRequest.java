package org.mathsena.mailservice.core;

import lombok.Data;

@Data
public record EmailRequest(String to, String subject, String body) {}
